package com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "usersdata")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "profile_picture")
	private String profilePicture;

	@Column(name = "photo_id")
	private String photoId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", profilePicture=" + profilePicture + ", photoId=" + photoId + "]";
	}

}
