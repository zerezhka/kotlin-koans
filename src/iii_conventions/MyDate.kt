package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return (this.year - other.year) * 100 + (this.month - other.month) * 10 + this.dayOfMonth - other.dayOfMonth
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {

    operator fun contains(d: MyDate): Boolean {
        if (d >= start && d <= endInclusive) return true
        else return false
    }

    override fun iterator(): Iterator<MyDate> = object :Iterator<MyDate>{
        var current = start

        override fun hasNext(): Boolean {
            return current<=endInclusive
        }

        override fun next(): MyDate {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val res = current
            current = current.nextDay()
            return res
        }
    }
}
