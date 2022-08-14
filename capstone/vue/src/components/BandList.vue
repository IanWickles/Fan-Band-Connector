<template>
  <div class="band-container">
    <div class="band">
      <tbody>
        <tr v-for="band in this.$store.state.bands" v-bind:key="band.bandId">
          <div class="card">
            <td>
              <h1 class="card-header-title is-size-2">{{ band.bandName }}</h1>
            </td>
            <router-link
              v-bind:to="{ name: 'band', params: { bandId: band.bandId } }"
              ><div class="card-image">
                <figure class="image">
                  <img :src="band.bandImage" />
                </figure>
              </div>
            </router-link>
            <div class="card-content">{{ band.bandDesc }}</div>
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
<style>
.card {
  background-color: #cc9200;
  background-image: url("https://www.transparenttextures.com/patterns/cardboard.png");
}
.card-header-title {
  color: white;
}
.card-content {
  color: white;
}
</style>
