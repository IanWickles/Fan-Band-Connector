<template
  ><div class="band-details">
    <h1 class="name">{{ band.name }}</h1>
    <h3 class="band-members">{{ band.bandMember }}</h3>
  </div>
</template>

<script>
// import Band from "@/components/Band.vue";
import bandService from "@/services/BandService.js";

export default {
  name: "band-details",
  props: {
    bandId: Number,
  },
  data() {
    return {
      topic: {
        id: 0,
        name: "",
        description: "",
        bandMember: "",
        manager_id: "",
      },
    };
  },
  created() {
    bandService.getBand(this.bandId).then((response) => {
      this.topic = response.data;
    });
  },
  // components: { Band },
};
</script>

<style></style>
