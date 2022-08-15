<template>
  <div>
    <h1>{{ this.$store.state.activeBand.title }}</h1>
    <h1 class="name">{{ this.$store.state.activeBand.bandName }}</h1>
    <img :src="band.bandImage" />
    <h2>Who Dat</h2>
    <h2 class="description">{{ band.bandDesc }}</h2>
    <h2 class="band-members">{{ band.members }}</h2>
    <!-- <h2 class="genre">{{ band.genre }}</h2> -->
    <!-- <div>
        <router-link :to="{ name: '', params: { id: band.id } }"
          >Edit</router-link
        >
      </div> -->
  </div>
</template>

<script>
import bandService from "@/services/BandService.js";

export default {
  name: "band-details",
  props: {
    bandId: Number,
  },
  computed: {
    band() {
      return this.$store.state.activeBand;
    },
  },
  methods: {},
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
  },
};
</script>

<style>
div {
  margin: 10px;
}
img {
  height: 500px;
}
</style>
