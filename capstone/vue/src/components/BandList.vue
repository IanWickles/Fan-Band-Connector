<template>
  <div :style="{'background-image':'url(https://images.pexels.com/photos/3353055/pexels-photo-3353055.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2)'}" class="band-container">
    <button class="big-button"><router-link v-bind:to="{ name: 'new-band' }">Create a New Band!</router-link></button>
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
/*.image {
  height: 360px;
  max-width: 360px;
}*/
</style>
