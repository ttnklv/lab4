const app = new Vue({
    el: '#app',
    data: {
        errors: [],
        y: null
    },
    methods: {
        checkForm: function (e) {

            this.errors = [];

            if (!this.y ) {
                this.errors.push('Enter y.');
            }

            if (this.y>5 || this.y < -5 ) {
                this.errors.push('Error y.');
            }

            if (!this.errors.length) {
                return true;
            }
            e.preventDefault();
        }
    }
});

new Vue({
    el: '#X',
    methods: {
        say: function (message) {
            let r1 = $(".x1");
            let r2 = $(".x2");
            let r3 = $(".x3");
            let r4 = $(".x4");
            let r5 = $(".x5");
            let r6 = $(".x6");
            let r7 = $(".x7");
            let r8 = $(".x8");
            let r9 = $(".x9");
            let r10 = $(message);
            r1.css({background: "white"});
            r2.css({background: "white"});
            r3.css({background: "white"});
            r4.css({background: "white"});
            r5.css({background: "white"});
            r6.css({background: "white"});
            r7.css({background: "white"});
            r8.css({background: "white"});
            r9.css({background: "white"});
            r10.css({background: "#464544"});
        }
    }
});