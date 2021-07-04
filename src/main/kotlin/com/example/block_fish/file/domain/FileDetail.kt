package com.example.block_fish.file.domain

import com.example.block_fish.user.support.jpa.BaseEntity
import javax.persistence.*

@Entity
class FileDetail(
    @OneToMany(cascade = [CascadeType.ALL])
    var starRanks: MutableList<StarRank> = mutableListOf(),

    var image: String,

    @Column(length = 500, nullable = false)
    var info: String,

    @Enumerated
    var osType: OsType,

    var downloadCount: Int
): BaseEntity() {
    fun addStarRank(starRank: StarRank) {
        starRanks.add(starRank)
        starRank.fileDetail = this
    }
}