package com.appxcore.quickSetup.dagger2.common.dependnecyinjection.activity

import com.appxcore.quickSetup.dagger2.common.dependnecyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

}