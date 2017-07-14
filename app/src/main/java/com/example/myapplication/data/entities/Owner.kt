package com.example.myapplication.data.entities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Owner(@SerializedName("login") var login: String? = null,
                 @SerializedName("id") var id: Int? = null,
                 @SerializedName("avatar_url") var avatarUrl: String? = null,
                 @SerializedName("gravatar_id") var gravatarId: String? = null,
                 @SerializedName("url") var url: String? = null,
                 @SerializedName("html_url") var htmlUrl: String? = null,
                 @SerializedName("followers_url") var followersUrl: String? = null,
                 @SerializedName("following_url") var followingUrl: String? = null,
                 @SerializedName("gists_url") var gistsUrl: String? = null,
                 @SerializedName("starred_url") var starredUrl: String? = null,
                 @SerializedName("subscriptions_url") var subscriptionsUrl: String? = null,
                 @SerializedName("organizations_url") var organizationsUrl: String? = null,
                 @SerializedName("repos_url") var reposUrl: String? = null,
                 @SerializedName("events_url") var eventsUrl: String? = null,
                 @SerializedName("received_events_url") var receivedEventsUrl: String? = null,
                 @SerializedName("type") var type: String? = null,
                 @SerializedName("site_admin") var siteAdmin: Boolean? = null) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Owner> = object : Parcelable.Creator<Owner> {
            override fun createFromParcel(source: Parcel): Owner = Owner(source)
            override fun newArray(size: Int): Array<Owner?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readValue(Int::class.java.classLoader) as Int?,
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readValue(Boolean::class.java.classLoader) as Boolean?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(login)
        dest.writeValue(id)
        dest.writeString(avatarUrl)
        dest.writeString(gravatarId)
        dest.writeString(url)
        dest.writeString(htmlUrl)
        dest.writeString(followersUrl)
        dest.writeString(followingUrl)
        dest.writeString(gistsUrl)
        dest.writeString(starredUrl)
        dest.writeString(subscriptionsUrl)
        dest.writeString(organizationsUrl)
        dest.writeString(reposUrl)
        dest.writeString(eventsUrl)
        dest.writeString(receivedEventsUrl)
        dest.writeString(type)
        dest.writeValue(siteAdmin)
    }
}
