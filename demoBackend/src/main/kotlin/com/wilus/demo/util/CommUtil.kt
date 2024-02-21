package com.wilus.demo.util

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.max

class CommUtil {
    fun toJulianDate(targetDate: LocalDate): Int {
        var jyy = ""
        val bYear = targetDate.year - 2000
        jyy = if (bYear < 0) {
            "0" + (targetDate.year - 1900)
        } else {
            if (bYear > 99) {
                "2" + (targetDate.year - 2100)
            } else {
                "1" + (targetDate.year - 2000)
            }
        }
        var dayOfYearString: String? = null
        val dayOfYear = targetDate.dayOfYear
        dayOfYearString = if (dayOfYear > 99) {
            dayOfYear.toString()
        } else if (dayOfYear > 9) {
            "0$dayOfYear"
        } else {
            "00$dayOfYear"
        }
        val jDate = jyy + dayOfYearString
        return jDate.toInt()
    }

    fun toJulianDate(targetDate: String?): Int {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val tDate = LocalDateTime.parse(targetDate, formatter)
        var jyy = ""
        val bYear = tDate.year - 2000
        jyy = if (bYear < 0) {
            "0" + (tDate.year - 1900)
        } else {
            if (bYear > 99) {
                "2" + (tDate.year - 2100)
            } else {
                "1" + (tDate.year - 2000)
            }
        }
        var dayOfYearString: String? = null
        val dayOfYear = tDate.dayOfYear
        dayOfYearString = if (dayOfYear > 99) {
            dayOfYear.toString()
        } else if (dayOfYear > 9) {
            "0$dayOfYear"
        } else {
            "00$dayOfYear"
        }
        val jDate = jyy + dayOfYearString
        return jDate.toInt()
    }

    fun toJulianDate(targetDate: LocalDateTime): Int {
        var jyy = ""
        val bYear = targetDate.year - 2000
        jyy = if (bYear < 0) {
            "0" + (targetDate.year - 1900)
        } else {
            if (bYear > 99) {
                "2" + (targetDate.year - 2100)
            } else {
                "1" + (targetDate.year - 2000)
            }
        }
        var dayOfYearString: String? = null
        val dayOfYear = targetDate.dayOfYear
        dayOfYearString = if (dayOfYear > 99) {
            dayOfYear.toString()
        } else if (dayOfYear > 9) {
            "0$dayOfYear"
        } else {
            "00$dayOfYear"
        }
        val jDate = jyy + dayOfYearString
        return jDate.toInt()
    }

    fun toStringFromJulian(julianDate: Int?): String {
        if (julianDate == null || julianDate == 0) {
            return ""
        }
        val now = LocalDate.now()
        var _0101 = LocalDate.parse(now.year.toString() + "-01-01")
        val jDateString = julianDate.toString() + ""
        var jYear = jDateString.substring(0, 3).toInt()
        val jDayOfYear = jDateString.substring(3, 6).toInt()
        jYear = if (jYear > 100) {
            if (jYear > 200) {
                2000 + (jYear - 200)
            } else {
                2000 + (jYear - 100)
            }
        } else {
            1900 + jYear
        }
        _0101 = _0101.plusDays((jDayOfYear - 1).toLong())
        return (jYear
            .toString() + "-" + (if (_0101.monthValue < 10) "0" + _0101.monthValue else _0101.monthValue)
                + "-" + if (_0101.dayOfMonth < 10) "0" + _0101.dayOfMonth else _0101.dayOfMonth)
    }

    fun toLocalDateFromJulian(julianDate: Int?): LocalDate? {
        if (julianDate == null || julianDate == 0) {
            return null
        }
        val now = LocalDate.now()
        var _0101 = LocalDate.parse(now.year.toString() + "-01-01")
        val jDateString = julianDate.toString() + ""
        var jYear = jDateString.substring(0, 3).toInt()
        val jDayOfYear = jDateString.substring(3, 6).toInt()
        jYear = if (jYear > 100) {
            if (jYear > 200) {
                2000 + (jYear - 200)
            } else {
                2000 + (jYear - 100)
            }
        } else {
            1900 + jYear
        }
        _0101 = _0101.plusDays((jDayOfYear - 1).toLong())
        return LocalDate.parse(jYear.toString() + "-" + _0101.monthValue + "-" + _0101.dayOfMonth)
    }

    fun toLocalDateTimeFromJulian(julianDate: Int): LocalDateTime {
        var _0101 = LocalDate.parse(LocalDate.now().year.toString() + "-01-01")
        val jDateString = julianDate.toString() + ""
        var jYear = jDateString.substring(0, 3).toInt()
        val jDayOfYear = jDateString.substring(3, 6).toInt()
        jYear = if (jYear > 100) {
            if (jYear > 200) {
                2000 + (jYear - 200)
            } else {
                2000 + (jYear - 100)
            }
        } else {
            1900 + jYear
        }
        _0101 = _0101.plusDays((jDayOfYear - 1).toLong())
        return LocalDateTime.of(
            jYear,
            _0101.monthValue,
            _0101.dayOfMonth,
            0,
            0,
            0,
            0
        )
    }

    fun ifNull(target: Any?, replacement: Any): Any {
        return target ?: replacement
    }

    /**
     * 문자열의 길이를 end 파라미터까지 자동으로 맞춰주는 기능.
     * 문자열의 길이가 end 이하인 경우, 자동으로 문자열의 길이만큼 자름.
     * 컬럼의 제한 길이까지 입력할 때 사용
     * (DB 기준으로 1부터 입력합니다.)
     * @param s String value
     * @param start 시작위치(min 1 (>0))
     * @param end   자를위치
     * @return new String
     */
    fun subStr(s: String?, start: Int, end: Int): String? {
        var start = start
        var end = end
        return if (s == null || s == "") {
            null
        } else {
            val sL = s.length
            start = max((start - 1).toDouble(), 0.0).toInt()
            if (sL < end) {
                end = sL
            }
            s.substring(start, end)
        }
    }

    fun NVL(target: Int?, parsed: Int): Int {
        return target ?: parsed
    }

    fun NVL(target: Long?, parsed: Long): Long {
        return target ?: parsed
    }

    fun NVL(target: String?, text: String): String {
        return if (target != null) {
            if (target == "") {
                text
            } else {
                target
            }
        } else {
            text
        }
    } //    public void sendResultMail() {
    //        Properties props = new Properties();
    //
    //        try {
    //            props.put("mail.smtp.port", 25);
    //            props.put("mail.smtp.starttls.enabled", true);
    //            props.put("mail.smtp.host", "10.82.82.202");
    //            props.put("mail.smtp.socketFactory.fallback", "false");
    //            props.put("mail.smtp.debug", "true");
    //            props.put("mail.smtp.auth", false);
    //
    //            Session mailSession = Session.getDefaultInstance(props);
    //        }
    //    }
}
