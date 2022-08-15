<template>
  <div>
    <tr v-for="message in this.$store.state.messages" v-bind:key="message.messageId">
      <h3 class="msgBody">{{message.messageBody}}</h3>
    </tr>
  </div>
</template>

<script>
import messageService from "../services/MessageService";
export default {
  name: "message-list",
  methods: {
  getMessages() {
    messageService.messageList().then ((response) => {
      this.$store.commit("SET_MESSAGES", response.data)
    })
  }
  },
  created() {
    this.getMessages();
  }
};
</script>

<style></style>
