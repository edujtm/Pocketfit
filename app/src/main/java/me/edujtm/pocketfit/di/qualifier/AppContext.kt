package me.edujtm.pocketfit.di.qualifier;


import javax.inject.Qualifier;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppContext
