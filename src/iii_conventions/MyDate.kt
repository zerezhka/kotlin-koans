package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    private val value: Int = year * 365 + month * 30 + dayOfMonth

    override fun compareTo(other: MyDate): Int {
        return this.value - other.value
    }

    infix operator fun times(i: Int): MyDate {
        return this.addTimeIntervals(TimeInterval.DAY,i)
    }

    infix operator fun plus(ti: TimeInterval): MyDate {
        return this.addTimeIntervals(ti,1)
    }

    infix operator fun plus(ti: RepeatedTimeInterval): MyDate {
        return this.addTimeIntervals(ti.ti,ti.n)
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)


enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    private val value: MyDate =
            if (this == DAY) MyDate(0,0,1)
            else if (this == WEEK) MyDate(0,0,7)
            else if (this == YEAR) MyDate(1,0,0)
            else MyDate(0,0,0)


    infix operator fun times(i: Int): RepeatedTimeInterval {
            return RepeatedTimeInterval(this,i)
    }

    operator fun plus(ti: TimeInterval): MyDate {
        return this.value.addTimeIntervals(ti,1)
    }
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {

    operator fun contains(d: MyDate): Boolean {
        if (d >= start && d <= endInclusive) return true
        else return false
    }

    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        var current = start

        override fun hasNext(): Boolean {
            return current <= endInclusive
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
class RepeatedTimeInterval(val ti: TimeInterval, val n: Int){

}
