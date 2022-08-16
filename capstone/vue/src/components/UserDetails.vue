<template>
  <div>
    <h1 class="name">Hello, {{ this.$store.state.user.username }}!</h1>
    <h3>Followed bands:</h3>
    <router-link tag="div" v-for="followedBand in followedBands" :key="followedBand.bandId" :to="{ name: 'band', params: { bandId: followedBand.bandId } }"><img :src="followedBand.bandImage" class="followed-band-image" />{{ followedBand.bandName }}</router-link>
  </div>
</template>

<script>
import userService from "@/services/UserService.js";

export default {
  name: "user-details",
  props: {
    userId: Number,
  },
  computed: {
    user() {
      return this.$store.state.activeUser;
    },
    followedBands() {
        return this.$store.state.followed;
    }
  },
  methods: {},
  created() {
    userService
      .get(this.userId)
      .then((response) => {
        this.$store.commit("SET_USER", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "not-found" });
        }
      });
    userService.getFollowedBands().then((response) => {
        this.$store.commit("SET_FOLLOWED", response.data);
    })
  },
};
</script>
<style>
.followed-band-image {
    width: 100px;
}
</style>
