<template>
  <div class="band-container">
    <input
      class="input is-rounded"
      v-model="input"
      name="byBand"
      type="text"
      placeholder="Search by band"
    />
    <input
      class="input is-rounded"
      name="byGenre"
      type="text"
      placeholder="Search by genre"
    />
    <h1>Bands:</h1>
    <div class="band">
      <tbody>
        <tr v-for="band in this.$store.state.bands" v-bind:key="band.bandId">
          <div class="container">
            <td>
              <strong>
                {{ band.bandName }}
              </strong>
            </td>
            <router-link
              v-bind:to="{ name: 'band', params: { bandId: band.bandId } }"
            >
              <figure class="image is-128x128">
                <img :src="band.bandImage" />
              </figure>
            </router-link>
            <h2 class="description">{{ band.bandDesc }}</h2>
            <!--<h2 class="band-members">{{ band.members }}</h2> -->
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
