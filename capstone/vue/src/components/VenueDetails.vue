<template>
  <div>
    <h1 class="name">{{ this.$store.state.activeVenue.venueName }}</h1>
    <h2 class="address">{{ venue.venueAddress }}</h2>
    <br />
    <h2>About:</h2>
    <h2 class="description">{{ venue.venueDesc }}</h2>
    <br />
    <h2>Map:</h2>
    <br />
    <iframe
      width="600"
      height="450"
      style="border:0"
      loading="lazy"
      allowfullscreen
      src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJ9cCHcw2mIIYRV7dOHIoKO4Q&key=AIzaSyBRq0tBrXJcI2Tff8JxVYGmR58CimOPI7o"
    ></iframe>
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
<<<<<<< Updated upstream
=======
        // console.log("here");
        // console.log(this.$store.state.activeVenue);
        // console.log(this.$store);
>>>>>>> Stashed changes
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
.address {
  text-align: center;
}
iframe {
  display: block;
  margin: auto;
}
</style>
