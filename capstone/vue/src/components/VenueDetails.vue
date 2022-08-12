<template
  ><div>
    <h1>{{ this.$store.state.activeVenue.title }}</h1>
    <h1 class="name">{{ this.$store.state.activeVenue.venueName }}</h1>
    <h2 class="address">{{ venue.venueAddress }}</h2>
    <h2 class="description">{{ venue.venueDesc }}</h2>
  </div>
</template>

<script>
import venueService from "@/services/VenueService.js";

export default {
  name: "venue-details",
  props: {
    venueId: Number,
  },
  computed: {
    venue() {
      return this.$store.state.activeVenue;
    },
  },
  methods: {},
  created() {
    venueService
      .get(this.venueId)
      .then((response) => {
        this.$store.commit("SET_ACTIVE_VENUE", response.data);
        console.log("here");
        console.log(this.$store.state.activeVenue);
        console.log(this.$store);
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
</style>
