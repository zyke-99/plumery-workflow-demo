package org.zyke.mock

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zyke.workflow.activity.LivenessCheckActivity
import org.zyke.workflow.activity.request.LivenessCheckActivityRequest
import org.zyke.workflow.activity.response.LivenessCheckActivityResponse
import kotlin.random.Random

class LivenessCheckActivityMockImpl : LivenessCheckActivity {

    private val logger: Logger = LoggerFactory.getLogger(LivenessCheckActivityMockImpl::class.java)

    override fun checkLiveness(livenessCheckActivityRequest: LivenessCheckActivityRequest): LivenessCheckActivityResponse {

        logger.info(
            "Doing liveness check with passport information {}",
            livenessCheckActivityRequest.passportInformation
        )
        Thread.sleep(1000)

        // TODO: this is just for demo purposes
        if (Random.nextInt(5) != 0) {
            logger.error("Call to liveness check service failed!")
            throw RuntimeException("Random failure occurred!")
        }

        logger.info(
            "Liveness check complete with passport information {}",
            livenessCheckActivityRequest.passportInformation
        )
        return LivenessCheckActivityResponse(true)
    }
}