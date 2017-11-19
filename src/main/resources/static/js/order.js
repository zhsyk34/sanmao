const vue = new Vue({
    el: '.container',
    data: {
        url: "orders",
        customers: [],
        customer: {},
        suppliers: [],
    },
    mounted: function () {
        this.$nextTick(function () {
            this.listCustomer();
            this.listSupplier();
        });
    },
    methods: {
        listCustomer: function () {
            axios.get("customers").then(resp => {
                const r = resp.data;
                if (r.code === 200) {
                    const data = r.data;
                    if (data) {
                        this.customers = data.data;
                    }
                } else {
                    alert("加载数据出错");
                }
            });
        },
        listSupplier: function () {
            axios.get("suppliers").then(resp => {
                const r = resp.data;
                if (r.code === 200) {
                    const data = r.data;
                    if (data) {
                        this.suppliers = data.data;
                        console.log(this.suppliers);
                    }
                } else {
                    alert("加载数据出错");
                }
            });
        },
        selectCustomer: function (customer) {
            console.log(customer);
            this.customer = customer;
        }
    }
});

// $('ul.dropdown-menu').on('click', 'li', function () {
//     const input = $(this).parents('.input-group').children('input');
//     input.val($(this).children('a').text());
// });