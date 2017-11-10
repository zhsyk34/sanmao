Vue.component('page', {
    props: {total: Number, number: Number},
    template: `
    <nav aria-label="page-navigation">
        <ul class="pagination">
            <li><a href="#" aria-label="previous" @click="change(1)"><span aria-hidden="true">&laquo;</span></a></li>
            <li v-for="page in (1, total)">
                <a href="#" v-text="page" @click="change(page)" :class="{active:page == number}"></a>
            </li>
            <li><a href="#" aria-label="next" @click="change(total)"><span aria-hidden="true">&raquo;</span></a></li>
        </ul>
    </nav>`,
    methods: {
        change: function (index) {
            this.$emit('change', index);
        }
    }
});
