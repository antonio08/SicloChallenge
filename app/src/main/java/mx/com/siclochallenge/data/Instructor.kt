/*
 * Created by Antonio Lozano on 5/29/2020.
 */
package mx.com.siclochallenge.data

import com.google.gson.annotations.SerializedName

class Instructor(id: Int, name: String, photoUrl: String) {

    @SerializedName("id")
    val mid = id

    @SerializedName("nombre")
    val mName = name

    @SerializedName("face_photo")
    val mPhotoUrl = photoUrl

}