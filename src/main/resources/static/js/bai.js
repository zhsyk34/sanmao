new Vue({
    el: '.container',
    data: {
        year: 1,
        years: [1, 2, 3, 4, 5],

        money: 0,

        interests: [3.75, 7.25, 10.25, 15, 18],
        interest: undefined,
        monthInterest: undefined

    },
    methods: {
        selectYear: function (year) {
            this.year = year;
        },
        selectCar: function () {
            const car = [3.75, 7.25, 10.25, 15, 18];
            for (let i = 0; i < 5; i++) {
                this.interests.splice(i, 1, car[i]);
            }
        },
        selectHome: function () {
            const home = [3.9, 7.5, 10.8, 16, 20];
            for (let i = 0; i < 5; i++) {
                this.interests.splice(i, 1, home[i]);
            }
        }
    },
    computed: {
        setInterest: function () {
            this.interest = this.interests[this.year - 1];
            this.monthInterest = this.interest / (this.year * 12);
            return this.interest + '%';
        },
        setMonthInterest: function () {
            return (this.monthInterest * 10).toFixed(3) + '‰';
        },
        principal: function () {
            return (this.money / (this.year * 12)).toFixed(3);
        },
        extra: function () {
            return (this.money * this.monthInterest / 100).toFixed(3);
        },
        repay: function () {
            return (this.money / (this.year * 12) + (this.money * this.monthInterest / 100)).toFixed(3);
        }
    }
});