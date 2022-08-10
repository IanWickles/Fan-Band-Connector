<template>
  <div class="band-container">
    <div class="band">
      <band
        v-bind:band="band"
        v-for="band in $store.state.bands"
        v-bind:key="band.id"
      />
    </div>
  </div>
</template>

<script>
import Band from "@/components/Band.vue";
import bandService from "@/services/BandService.js";

export default {
  name: "band-list",
  data() {
    return {
      bands: [],
    };
  },
  created() {
    bandService.list().then((response) => {
      this.bands = response.data;
      this.$store.commit("SET_BANDS", this.bands);
      this.isLoading = false;
    });
  },
  components: { Band },
  // methods: {
  //   getBands() {
  //     bandService.list().then((response) => {
  //       this.bands = response.data;
  //     });
  //   },
  // },
};
</script>

<style></style>
