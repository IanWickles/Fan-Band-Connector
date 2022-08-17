<template>
  <div>
    <h1 class="name">{{ this.$store.state.activeBand.bandName }}</h1>
    <div class="manager-hub">
      <button class="manager-edit">Edit</button> |
      <button class="manager-show">Post Show</button>
    </div>
    <figure class="this-image"><img :src="band.bandImage" /></figure>
    <h1>Who Dat</h1>
    <h2 class="description">{{ band.bandDesc }}</h2>
    <h1>Members:</h1>
    <ul>
      <li v-for="genre in band.genres" :key="genre.genreId">
        {{ genre.genreName }}
      </li>
    </ul>
    <h2 class="band-members">{{ band.members }}</h2>
    <div class="user-hub">
      <button class="big-button" @click="followBand" v-if="!isFollowing">
        Follow
      </button>
      <button class="big-button" @click="unfollowBand" v-if="isFollowing">
        Unfollow
      </button>
      <!--Make this follow/unfollow -->
    </div>
    <br />
    <h1>Photo Gallery</h1>
    insert photo gallery here
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
    isFollowing() {
      return (
        this.$store.state.followed.find((band) => band.bandId == this.bandId) !=
        undefined
      );
    },
    genres() {
      return this.$store.state.activeBand.genres;
    },
  },
  methods: {
    followBand() {
      userService.followBand(this.bandId).then(() => {
        this.updateFollowedList();
      });
    },
    updateFollowedList() {
      userService.getFollowedBands().then((followedResponse) => {
        this.$store.commit("SET_FOLLOWED", followedResponse.data);
      });
    },
    unfollowBand() {
      userService.unfollowBand(this.bandId).then(() => {
        this.updateFollowedList();
      });
    },
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
    bandService.getBandGenres(this.bandId).then((response) => {
      this.$store.commit("SET_BAND_GENRES", response.data);
    });
    this.updateFollowedList();
  },
};
</script>

<style>
.manager-hub {
  text-align: center;
}
.user-hub {
  text-align: center;
}
.description {
  text-align: center;
}
.band-members {
  text-align: center;
}
.this-image {
  display: block;
  margin: auto;
  max-width: 60%;
}
</style>
