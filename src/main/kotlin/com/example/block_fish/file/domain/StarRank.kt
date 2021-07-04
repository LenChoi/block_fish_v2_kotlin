package com.example.block_fish.file.domain

import com.example.block_fish.user.support.jpa.BaseEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class StarRank(
    var star: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    var fileDetail: FileDetail
): BaseEntity()
