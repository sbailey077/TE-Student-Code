<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>

      <div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
      </div>
    <comments-list v-else v-bind:comments="card.comments" />
  </div>
</template>

<script>
import boardService from '@/services/BoardService'
import CommentsList from '@/components/CommentsList'
export default {
  name: "card-detail",
  components: {
    CommentsList
  },
  data() {
    return {
      card: {
        title: '',
        description: '',
        status: '',
        comments: []
      },
      isLoading: true
    }
  },
  created() {
    const boardID = this.$route.params.boardID;
    const cardID = this.$route.params.cardID;
    boardService.getCard(boardID, cardID).then(cardFromResponse => {
      this.card = cardFromResponse;
      this.isLoading = false;
    })
   
  }
};
</script>
