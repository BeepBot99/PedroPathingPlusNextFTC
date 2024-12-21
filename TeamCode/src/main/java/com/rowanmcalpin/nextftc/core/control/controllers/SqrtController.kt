package com.rowanmcalpin.nextftc.core.control.controllers

import kotlin.math.abs
import kotlin.math.sqrt

/**
 * This is a Square Root Controller, which is a proportional controller that uses the square root of
 * the error instead of just the error.
 *
 * @param kS constant multiplier for the square-rooted error.
 */
open class SqrtController(val kS: Double): Controller {
    override var target: Double = 0.0

    var setPointTolerance: Double = 0.0

    override fun calculate(reference: Double): Double {
        val error = target - reference

        return (sqrt(error) * kS)
    }

    /**
     * Whether this controller is within a certain distance of the [target].
     *
     * @param reference the current location of the motor being controlled
     */
    fun atSetPoint(reference: Double): Boolean {
        if (abs(target - reference) <= setPointTolerance) {
            return true
        }

        return false
    }

    override fun reset() { }
}