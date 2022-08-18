<template>
  <div>
    <div
      :style="{
        'background-image':
          'url(https://images.pexels.com/photos/3353055/pexels-photo-3353055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2)',
      }"
      class="band-container"
    >
      <table class="item band">
        <tr>
          <td>
            <input
              id="band-filter"
              class="input is-rounded"
              v-model="filter.bandName"
              name="byBand"
              type="text"
              placeholder="Search by band"
            />
          </td>
        </tr>
        <tr>
          <td>
            <input
              class="input is-rounded"
              name="byGenre"
              type="text"
              placeholder="Search by genre"
            />
          </td>
        </tr>
        
          <tr v-for="band in filteredList" :key="band.bandId">
            <td class="card">
              <router-link
                v-bind:to="{
                  name: 'band',
                  params: { bandId: band.bandId },
                }"
              >
                <h1 class="card-header-title is-size-2">
                  {{ band.bandName }}
                </h1></router-link
              >
              <router-link
                v-bind:to="{
                  name: 'band',
                  params: { bandId: band.bandId },
                }"
                ><figure class="image">
                  <img :src="band.bandImage" /></figure
              ></router-link>
              <div class="card-content">{{ band.bandDesc }}</div>
            </td>
            <p v-for="genre in genres" :key="genre.genreId" params: {bandId: band.bandId } >
              {{ genre.genreName }}
            </p>
          </tr>
       
      </table>
    </div>
  </div>
</template>

<script>
import bandService from "@/services/BandService.js";

export default {
  name: "band-list",
  setup() {},
  data() {
    return {
      filter: {
        bandId: 0,
        bandName: "",
        bandImage: "",
        bandDesc: "",
        Members: "",
        mgrId: "",
      },
    };
  },
  computed: {
    filteredList() {
      let bandList = this.$store.state.bands;
      if (this.filter.bandName != "") {
        bandList = bandList.filter((band) =>
          band.bandName
            .toLowerCase()
            .includes(this.filter.bandName.toLowerCase())
        );
      }
      //  if (this.$store.state.bands.genre != "") {
      //   results = results.filter((band) =>
      //     band.genre.toLowerCase().includes(this.filter.genre.toLowerCase())
      //   );
      // }
      return bandList;
    },
  },
  methods: {
    getBands() {
      bandService.list().then((response) => {
        this.$store.commit("SET_BANDS", response.data);
      });
    },
    getBandGenres(bandId) {
      bandService.getBandGenres(bandId).then((response) => {
        this.$store.commit("SET_BAND_GENRES", response.data);
      });
    },
  },
  created() {
    this.getBands();
    this.getBandGenres();
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
  background-color: #f7ff00;
  border-radius: 12px;
  background-image: url("https://www.transparenttextures.com/patterns/my-little-plaid.png");
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
