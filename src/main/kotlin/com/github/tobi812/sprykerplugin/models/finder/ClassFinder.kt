package com.github.tobi812.sprykerplugin.models.finder

import com.github.tobi812.sprykerplugin.models.renderer.dto.PhpClassInterface
import com.github.tobi812.sprykerplugin.models.renderer.dto.PhpClassItem
import com.intellij.openapi.project.Project
import com.jetbrains.php.PhpIndex
import com.jetbrains.php.lang.psi.elements.PhpClass

class ClassFinder(private val project: Project) : ClassFinderInterface {
    override fun doesClassExist(fullQualifiedName: String): Boolean {
        val phpClassCollection = getPhpClassCollection(fullQualifiedName)
        return phpClassCollection.isNotEmpty()
    }

    override fun findClass(fullQualifiedCoreName: String): PhpClassInterface? {
        val phpClassCollection = getPhpClassCollection(fullQualifiedCoreName)
        if (phpClassCollection.isNotEmpty()) {
            val phpClass = phpClassCollection.iterator().next()
            val parentName = phpClass.name
            val namespace = phpClass.namespaceName
            return PhpClassItem(namespace, parentName)
        }

        return null
    }

    private fun getPhpClassCollection(fullQualifiedName: String): Collection<PhpClass> {
        return PhpIndex.getInstance(project).getAnyByFQN(fullQualifiedName)
    }
}