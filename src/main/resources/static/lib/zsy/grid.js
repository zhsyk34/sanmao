Vue.component('grid', {
    props: {titles: Array, rows: Array},
    template: `
    <table class="table table-striped">
        <thead>
        <tr>
            <th v-for="title of titles" v-text="title"></th>
            <th>
                <button class="btn btn-sm btn-success" @click="insert">新增</button>
            </th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="row of rows">
            <td v-for="title of titles" v-text="row[title]"></td>
            <td>
                <button class="btn btn-sm btn-primary" @click="update(row)">编辑</button>
                <button class="btn btn-sm btn-danger" @click="remove(row)">删除</button>
            </td>
        </tr>
        </tbody>
    </table>`,
    methods: {
        insert: function () {
            this.$emit('insert');
        },
        update: function (row) {
            this.$emit('update', row);
        },
        remove: function (row) {
            this.$emit('remove', row);
        },
    }
});


