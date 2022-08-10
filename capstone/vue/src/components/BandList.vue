<template>
  <div class="band-container">
    <band
      v-bind:band="band"
      v-for="band in $store.state.bands"
      v-bind:key="band.id"
    />
  </div>
</template>

<script>
import Band from "@/components/Band.vue";
import bandService from "@/services/BandService.js";

export default {
  name: "band-list",
  components: { Band },
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
