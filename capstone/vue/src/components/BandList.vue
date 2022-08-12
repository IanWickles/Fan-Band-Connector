<template>
  <div class="band-container">
    <div class="band">
      <tbody>
        <tr v-for="band in this.$store.state.bands" v-bind:key="band.bandId">
          <div class="container">
            <td>
              <router-link
                v-bind:to="{ name: 'band', params: { bandId: band.bandId } }"
                >{{ band.bandName }}</router-link
              >
              <!-- <router-link v-bind:to="{ name: 'profile' }"> -->
            </td>
            <!-- <h2 class="description">{{ band.bandDesc }}</h2> -->
            <!-- <h2 class="band-members">{{ band.members }}</h2> -->
            <!-- <h2 class="genre">{{ band.genre }}</h2> -->
          </div>
        </tr>
      </tbody>
    </div>
  </div>
</template>

<script>
import bandService from "@/services/BandService.js";

export default {
  name: "band-list",
  methods: {
    getBands() {
      bandService.list().then((response) => {
        this.$store.commit("SET_BANDS", response.data);
      });
    },
  },
  created() {
    this.getBands();
  },
};
</script>

<style></style>
