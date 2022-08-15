<template>
  <div>
    <h1 class="name">Hello, {{ this.$store.state.user.username }}!</h1>
    </div>
</template>

<script>
<<<<<<< HEAD
import userService from "@/services/UserService.js";

export default {
  name: "user-details",
  props: {
    userId: Number,
  },
  computed: {
    user() {
      return this.$store.state.activeUser;
    },
  },
  methods: {},
  created() {
    userService
      .get(this.userId)
      .then((response) => {
        this.$store.commit("SET_USER", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "not-found" });
        }
      });
  },
};
=======
>>>>>>> 73b752da4074846a8edd17544b06454db1149cd2
</script>
<style>

</style>
