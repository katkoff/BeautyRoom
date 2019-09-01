package com.mdgroup.beautyroom.domain.model

sealed class GenericResult<out T : Any> {

    class Success<T : Any>(
        val data: T
    ) : GenericResult<T>()

    class Error(
        val throwable: Throwable
    ) : GenericResult<Nothing>()

    fun empty(): GenericResult<Unit> {
        return Success(Unit)
    }

    inline fun <To : Any> map(block: (T) -> To): GenericResult<To> {
        return when (this) {
            is Success -> from { block.invoke(this.data) }
            is Error -> this
        }
    }

    inline fun <To : Any> flatMap(block: (T) -> GenericResult<To>): GenericResult<To> {
        return try {
            return when (this) {
                is Success -> block.invoke(this.data)
                is Error -> this
            }
        } catch (e: Throwable) {
            Error(e)
        }
    }

    companion object {

        fun <T : Any> from(data: T): GenericResult<T> {
            return Success(data)
        }

        inline fun <T : Any> from(block: () -> T): GenericResult<T> {
            return try {
                Success(block.invoke())
            } catch (e: Throwable) {
                Error(e)
            }
        }

        fun empty(): GenericResult<Unit> {
            return Success(Unit)
        }
    }
}
