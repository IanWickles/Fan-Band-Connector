<template>
  <div class="venue-container">
    <input
      class="input is-rounded"
      v-model="input"
      name="byTitle"
      type="text"
      placeholder="Search by venue"
    />
    <div class="venue">
      <tbody>
        <tr
          v-for="venue in this.$store.state.venues"
          v-bind:key="venue.venueId"
        >
          <div class="card">
            <td>
              <router-link class="card-header"
                v-bind:to="{ name: 'venue', params: { venueId: venue.venueId } }"
                >{{ venue.venueName }}</router-link
              >
            </td>
            <h2 class="card-header">{{ venue.venueAddress }}</h2>
            <h2 class="card-content">{{ venue.venueDesc }}</h2>
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
