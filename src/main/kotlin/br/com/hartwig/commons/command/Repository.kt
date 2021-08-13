package br.com.hartwig.commons.command

import java.util.UUID

interface Repository<T> {
    fun create(entity: T): UUID?
    fun get(id: UUID): T?
    fun remove(id: UUID)
    fun list(): List<T?>
    fun update(entity: T)
}
