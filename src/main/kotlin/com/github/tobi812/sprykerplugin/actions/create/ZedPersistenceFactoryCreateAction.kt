package com.github.tobi812.sprykerplugin.actions.create

import com.github.tobi812.sprykerplugin.actions.AbstractCreateClassTypeAction
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import pav.sprykerFileCreator.SprykerIcons
import pav.sprykerFileCreator.model.generator.SprykerConstants
import java.lang.Exception

class ZedPersistenceFactoryCreateAction : AbstractCreateClassTypeAction(
    "Create Zed PersistenceFactory",
    "Create Zed PersistenceFactory",
    SprykerIcons.SPRYKER_ICON
) {
    @Throws(Exception::class)
    override fun create(s: String, psiDirectory: PsiDirectory): Array<PsiElement> {
        return arrayOfNulls(0)
    }

    override fun getErrorTitle(): String {
        return null
    }

    override fun getCommandName(): String {
        return "Create Zed Persistence Factory"
    }

    override fun getActionName(psiDirectory: PsiDirectory, s: String): String {
        return "Create Zed Persistence Factory"
    }

    override val classType: String
        protected get() = SprykerConstants.ZED_PERSISTENCE_FACTORY
}