<template>
  <div>
    <user-details />
    <message-list />
  </div>
</template>
<!--
//uses userDetails component
//profile info --&picture? 
//need to have a message section -- date descending
// sort button, by band/date
-->
<script>
import MessageList from "../components/MessageList.vue";
import UserDetails from "../components/UserDetails.vue";
export default {
  components: { UserDetails, MessageList },
};
</script>

<style></style>
