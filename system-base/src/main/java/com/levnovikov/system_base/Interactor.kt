package com.levnovikov.system_base

import android.os.Parcelable

import com.levnovikov.system_base.node_state.ActivityState
import com.levnovikov.system_base.node_state.NodeState

abstract class Interactor<R : Router>(
        protected var router: R,
        protected var activityState: ActivityState) {

    protected val nodeState: NodeState? = activityState.findNodeState(router.javaClass)

    protected val nodeStateData: Parcelable? = nodeState?.data

    open fun restoreState() {
        nodeState?.let { router.setState(it) }
    }

    fun hasSavedState(): Boolean {
        return activityState.findNodeState(router.javaClass) != null
    }
}
