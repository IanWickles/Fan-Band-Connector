<template>
  <div>
    <!--  <button v-on:click="sortByDate()" class="button is-info is-outlined" id="sortDate">Sort By Date</button> -->
    <button
      v-on:click="sortByBand()"
      class="button is-success is-outlined"
      id="sortBand"
    >
      Sort by Band
    </button>
    <tr
      v-for="message in this.$store.state.messages"
      v-bind:key="message.messageId"
    >
      From:
      <h5 class="bandName">{{ message.bandName }}</h5>
      <h3 class="msgBody">{{ message.messageBody }}</h3>
      <h4>{{ message.messageTimestamp }}</h4>

      <!--<button class="button is-danger">Delete</button>-->
    </tr>
  </div>
</template>

<script>
import messageService from "../services/MessageService";
export default {
  name: "message-list",
  
  methods: {
    getMessages() {
      messageService.messageList().then((response) => {
        this.$store.commit("SET_MESSAGES", response.data);
      });
    },
    sortByBand() {     
      this.messages.sort(this.compare(this.messages.bandName));
    },
    compareBand(a, b) {
      //Ascending
      if (a.bandName.toLowerCase() < b.bandName.toLowerCase()) {
        return -1;
      }
      if (a.bandName.toLowerCase() > b.bandName.toLowerCase()) {
        return 1;
      }
      return 0;
    },

    //  sortByBand() {
    //     compareBand(a,b) { //Ascending
    //     if ( a.bandName.toLowerCase() < b.bandName.toLowerCase() ){
    //       return -1;
    //     }
    //     if ( a.bandName.toLowerCase() > b.bandName.toLowerCase() ){
    //       return 1;
    //     }
    //     return 0;
    //     }
    //     return this.data.messageList.sort(this.compareBand());
    //   },

    sortByDate() {},

    compareDate(a, b) {
      //Ascending
      if (a.messageTimestamp < b.messageTimestamp) {
        return -1;
      }
      if (a.messageTimestamp > b.messageTimestamp) {
        return 1;
      }
      return 0;
    },
  },
  created() {
    this.getMessages();
  },
  computed: {
    sortedByBand: function compare(a,b) {
      if (a.bandName.toLowerCase() < b.bandName.toLowerCase()) {
        return -1;
      }
      if (a.bandName.toLowerCase() > b.bandName.toLowerCase()) {
        return 1;
      }
      return 0;
}  }
};
</script>

<style></style>
