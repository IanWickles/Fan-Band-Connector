<template>
  <div>
    <!--
     <input
      class="input is-rounded"
      name="byGenre"
      type="text"
      placeholder="Search by genre"
     /> -->

    <div
      :style="{
        'background-image':
          'url(https://images.pexels.com/photos/3353055/pexels-photo-3353055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2)',
      }"
      class="band-container"
    >
    <div class="band">

      <tbody>
        <tr>
          <!-- <div class="item band" v-for="band in filteredList()" :key="band.bandName"> -->
          <input
            class="input is-rounded"
            v-model="results.bandName"
            name="byBand"
            type="text"
            placeholder="Search by band"
          />
        </tr>
        <!-- <tr v-for="band in this.$store.state.bands" v-bind:key="band.bandId"> -->
        <tr v-for="band in filteredList()" v-bind:key="band.bandId">
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
            <!-- <h2 class="genre">{{ band.genre }}</h2> -->
          </div>
        </tr>
      </tbody>
    </div>
    <!-- </div> -->
  </div>
</template>

<script>
import bandService from "@/services/BandService.js";

export default {
  name: "band-list",
  setup() {},
  data() {
    return {
      results: {
        bandId: 0,
        bandName: "",
        bandImage: "",
        bandDesc: "",
        Members: "",
        mgrId: "",
      },
    };
  },
  methods: {
    getBands() {
      bandService.list().then((response) => {
        this.$store.commit("SET_BANDS", response.data);
      });
    },
    filterList() {
      let bandList = this.$store.state.bands;

      if (this.filter != "") {
        bandList = bandList.filter((band) =>
          band.bandName
            .toLowerCase()
            .includes(this.filter.bandName.toLowerCase())
        );
      }
      return bandList;
    },
    //  if (this.$store.state.bands.genre != "") {
    //   results = results.filter((band) =>
    //     band.genre.toLowerCase().includes(this.filter.genre.toLowerCase())
    //   );
    // }
  },
  created() {
    this.getBands();
  },
};
</script>

<style>
.band {
  margin: 0vw 7vw 0vw 7vw;
  border-radius: 12px;
  background-image: url(https://images.pexels.com/photos/3353055/pexels-photo-3353055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2);
}
.card {
  padding: 20px;
  background-color: #cc9200;
  border-radius: 12px;
  background-image: url("https://www.transparenttextures.com/patterns/cardboard.png");
}
.card-header-title {
  color: white;
}
.card-content {
  color: white;
}
.image {
  display: block;
  margin: auto;
  max-width: 90%;
}
</style>
