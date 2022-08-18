<template>
  <div class="venue-container">
    <table>
      <tr>
        <td>
          <input
            class="input is-rounded"
            v-model="filter.venueName"
            name="byTitle"
            type="text"
            placeholder="Search by venue"
          />
        </td>
      </tr>
      <td>
        <tr v-for="venue in filteredList" :key="venue.venueId" class="venue">
          <div class="card">
            <td>
              <router-link
                class="card-header"
                v-bind:to="{
                  name: 'venue',
                  params: { venueId: venue.venueId },
                }"
                >{{ venue.venueName }}</router-link
              >
            </td>
            <h2 class="card-header" id="addy">{{ venue.venueAddress }}</h2>
            <h2 class="card-content" id="vdesc">{{ venue.venueDesc }}</h2>
          </div>
        </tr>
      </td>
    </table>
  </div>
</template>

<script>
import venueService from "@/services/VenueService.js";

export default {
  name: "venue-list",
  data() {
    return {
      filter: {
        venueId: 0,
        venueName: "",
        venueAddress: "",
        venueDesc: "",
        venueMap: "",
      },
    };
  },
  computed: {
    filteredList() {
      let venueList = this.$store.state.venues;
      if (this.filter.venueName != "") {
        venueList = venueList.filter((venue) =>
          venue.venueName
            .toLowerCase()
            .includes(this.filter.venueName.toLowerCase())
        );
      }
      return venueList;
    },
  },
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

<style scoped>
.container {
  padding: 10px;
}
.card-header{
  text-align: center;
  color: white;
}
</style>
