<template>
  <div>
    <input
      class="input is-rounded"
      v-model="bands.name"
      name="byBand"
      type="text"
      placeholder="Search by band"
    />
    <input
      class="input is-rounded"
      v-model="bands.genre"
      name="byGenre"
      type="text"
      placeholder="Search by genre"
    />

    <div
      :style="{
        'background-image':
          'url(https://images.pexels.com/photos/3353055/pexels-photo-3353055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2)',
      }"
      class="band-container"
    >
      <tbody>
        <tr v-for="band in this.$store.state.bands" v-bind:key="band.bandId">
          <div class="card">
            <td>
              <h1>{{ band.bandName }}</h1>
            </td>
            <router-link
              v-bind:to="{ name: 'band', params: { bandId: band.bandId } }"
            >
              <div class="card-image">
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
data() {
    return {
      bands: {
        bandId: 0,
      bandName: "",
      bandImage: "",
      bandDesc: "",
      Members: "",
      mgrId: ""
      },
  methods: {
    getBands() {
      bandService.list().then((response) => {
        this.$store.commit("SET_BANDS", response.data);
      });
    },
    filterBandList() {
      let results = this.$store.state.bands;
      if (this.$store.state.bands.name != "") {
        results = results.filter((band) =>
          band.name.toLowerCase().includes(this.filter.name.toLowerCase())
        );
      }
      // if (this.$store.state.bands.genre != "") {
      //   results = results.filter((band) =>
      //     band.genre.toLowerCase().includes(this.filter.genre.toLowerCase())
      //   );
      // }
    },
  },
  created() {
    this.getBands();
  },
};
</script>
<style>
.card {
  padding: 20px;
  background-color: #cc9200;
  background-image: url("https://www.transparenttextures.com/patterns/cardboard.png");
}
.card-header-title {
  color: white;
}
.card-content {
  color: white;
}
/*.image {
  height: 360px;
  max-width: 360px;
}*/
</style>
