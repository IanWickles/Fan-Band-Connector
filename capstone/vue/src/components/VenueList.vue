<template>
  <div class="venue-container">
    <div class="venue">
      <tbody>
        <tr
          v-for="venue in this.$store.state.venues"
          v-bind:key="venue.venueId"
        >
          <div class="container">
            <td>
              <router-link
                v-bind:to="{ name: 'venue', params: { id: venue.venueName } }"
                >{{ venue.venueName }}</router-link
              >
            </td>
            <h2 class="address">{{ venue.venueAddress }}</h2>
            <h2 class="description">{{ venue.venueDesc }}</h2>
          </div>
        </tr>
      </tbody>
    </div>
  </div>
</template>

<script>
import venueService from "@/services/VenueService.js";

export default {
  name: "venue-list",
  methods: {
    getVenues() {
      venueService.list().then((response) => {
        this.$store.commit("SET_VENUES", response.data);
      });
    },
    deleteVenue() {},
  },
  created() {
    this.getVenues();
  },
};
</script>

<style>
.container {
  padding: 10px;
}
</style>
