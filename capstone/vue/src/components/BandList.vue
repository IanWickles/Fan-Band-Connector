<template>
  <div class="band-container">
    <div class="band">
      <tbody>
        <tr v-for="band in this.$store.state.bands" v-bind:key="band.bandId">
          <div class="card">
            <td>
              <router-link
                v-bind:to="{ name: 'band', params: { bandId: band.bandId } }"
                ><h1 class="card-header-title is-size-2">
                  {{ band.bandName }}
                </h1></router-link
              >
            </td>

            <div class="card-image">
              <router-link
                v-bind:to="{ name: 'band', params: { bandId: band.bandId } }"
                ><figure class="image">
                  <img :src="band.bandImage" /></figure
              ></router-link>
            </div>

            <div class="card-content">{{ band.bandDesc }}</div>

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
.band {
  margin: 0vw 7vw 0vw 7vw;
  border-radius: 12px;
  background-image: url(https://images.pexels.com/photos/3353055/pexels-photo-3353055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2);
}
.card {
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
