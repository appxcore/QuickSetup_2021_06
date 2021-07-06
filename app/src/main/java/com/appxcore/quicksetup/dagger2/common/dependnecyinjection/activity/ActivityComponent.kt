package com.appxcore.quicksetup.dagger2.common.dependnecyinjection.activity

import com.appxcore.quicksetup.dagger2.common.dependnecyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

}