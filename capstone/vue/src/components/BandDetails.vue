<template>
  <div>
    
    <h1 class="name">{{ this.$store.state.activeBand.bandName }}</h1>
    <div class="managerhub">
    <button class="manageredit"><router-link v-bind:to="{ name: 'update-band' }">Edit</router-link></button> |
    <button class="managershow">Post Show</button>
    <button class="managermessage"><router-link v-bind:to="{ name: 'new-message' }">Send Message</router-link> </button>
    </div>
    <figure class="thisimage"><img :src="band.bandImage" /></figure>
    <h1>Who Dat</h1>
    <h2 class="description">{{ band.bandDesc }}</h2>
    <h1>Members:</h1>
    <ul>
      <li v-for="genre in genres" :key="genre.genreId">{{ genre.genreName }}</li>
      </ul>
    <h2 class="band-members">{{ band.members }}</h2>
    <div class="userhub">
      <button class="big-button" @click="followBand" v-if="!isFollowing">Follow</button>
      <button class="big-button" @click="unfollowBand" v-if="isFollowing">Unfollow</button>
      <!--Make this follow/unfollow -->
      </div>
      <br>
      <h1>Photo Gallery</h1>
      <ul class="photo-gallery">
      <li v-for="photo in photos" :key="photo.photoId"><img :src="photo.photoImage" class="galleryimg"/></li>
      </ul>
    <!-- <div>
        <router-link :to="{ name: '', params: { id: band.id } }"
          >Edit</router-link
        >
      </div> -->
  </div>
</template>

<script>
import bandService from "@/services/BandService.js";
import userService from "@/services/UserService.js";

export default {
  name: "band-details",
  props: {
    bandId: Number,
  },
  computed: {
    band() {
      return this.$store.state.activeBand;
    },
    photos() {
      return this.$store.state.activeBandPhotos;
    },
    genres() {
      return this.$store.state.activeBandGenres;
    },
    isFollowing() {
      return this.$store.state.followed.find(band=>band.bandId==this.bandId)!=undefined;
    }
  },
  methods: {
    followBand() {
      userService.followBand(this.bandId).then(()=>{
        this.updateFollowedList();
      });
    },
    updateFollowedList() {
      userService.getFollowedBands().then(followedResponse=>{
        this.$store.commit("SET_FOLLOWED", followedResponse.data);
      });
    },
    updateBandGenres() {
      bandService.getBandGenres(this.bandId).then((response)=>{
        this.$store.commit("SET_BAND_GENRES", response.data);
      });
    },
    updateBandPhotos() {
      bandService.getBandPhotos(this.bandId).then((response)=>{
        this.$store.commit("SET_BAND_PHOTOS", response.data);
      })
    },
    unfollowBand() {
      userService.unfollowBand(this.bandId).then(()=>{
        this.updateFollowedList();
      });
    }
  },
  created() {
    bandService
      .get(this.bandId)
      .then((response) => {
        this.$store.commit("SET_ACTIVE_BAND", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "not-found" });
        }
      });
      this.updateFollowedList();
      this.updateBandGenres();
      this.updateBandPhotos();
  },
};
</script>

<style>
.managerhub {
  text-align: center;
}
.userhub {
  text-align: center;
}
.description {
  text-align: center;
}
.band-members {
  text-align: center;
}
.thisimage {
  display: block;
  margin: auto;
  max-width: 60%;
}
.photo-gallery {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
}
.galleryimg {
  max-width: 80%;
}
</style>
