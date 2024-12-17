package org.zyke.workflow.activity

import io.temporal.activity.ActivityInterface
import io.temporal.activity.ActivityMethod
import org.zyke.workflow.activity.request.LivenessCheckActivityRequest
import org.zyke.workflow.activity.response.LivenessCheckActivityResponse

@ActivityInterface
interface LivenessCheckActivity {

    @ActivityMethod
    fun checkLiveness(livenessCheckActivityRequest: LivenessCheckActivityRequest): LivenessCheckActivityResponse
}