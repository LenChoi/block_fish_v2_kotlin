package com.example.block_fish.file.domain

import com.example.block_fish.user.support.jpa.BaseEntity
import java.nio.channels.FileLock
import javax.persistence.*

@Entity
class File(
    @Column(length = 50, nullable = false)
    var name: String,

    @Column(length = 100, nullable = false)
    var fileUrl: String,

    @Column(length = 100, nullable = false)
    var chainAddress: String,

    @Enumerated
    var status: FileStatus = FileStatus.ACTIVE,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var fileDetail: FileDetail
) : BaseEntity()