from flask import Flask, jsonify

app = Flask(__name__)

products = [
    {
        'name': 'Intel Core i9-11900K',
        'image': 'cpu0',
        'rating':'3',
        'price':'300$',
        'description': '\uD83D\uDD25 Intel Core i9-11900K: This high-end CPU from Intel is designed for gamers and power users who demand the best performance. With 8 cores and 16 threads, it can handle even the most demanding applications and games with ease. It also features Intel\'s latest technologies, including PCIe 4.0 and Thunderbolt 4.'
    },
    {
        'name': 'AMD Ryzen 9 5950X',
        'image': 'cpu1',
        'rating':'2.5',
        'price':'350$',
        'description': '\uD83D\uDCAA AMD Ryzen 9 5950X: This top-of-the-line CPU from AMD is designed for content creators and professionals who need the best performance for their work. With 16 cores and 32 threads, it can handle even the most demanding tasks with ease. It also features AMD\'s latest technologies, including PCIe 4.0 and support for DDR4 memory speeds up to 3200MHz.'
    },
    {
        'name': 'Intel Core i7-11700K',
        'image': 'cpu2',
        'rating':'3.4',
        'price':'270$',
        'description': '\uD83D\uDCBB Intel Core i7-11700K: This mid-range CPU from Intel is designed for gamers and power users who want a balance between performance and price. With 8 cores and 16 threads, it can handle most applications and games with ease. It also features Intel\'s latest technologies, including PCIe 4.0 and Thunderbolt 4.'
    },
    {
        'name': 'AMD Ryzen 7 5800X',
        'image': 'cpu3',
        'rating':'3.8',
        'price':'400$',
        'description': '\uD83D\uDE80 AMD Ryzen 7 5800X: This high-end CPU from AMD is designed for gamers and power users who demand the best performance. With 8 cores and 16 threads, it can handle even the most demanding applications and games with ease. It also features AMD\'s latest technologies, including PCIe 4.0 and support for DDR4 memory speeds up to 3200MHz.'
    },
    {
        'name': 'Intel Core i5-11600K',
        'image': 'cpu4',
        'rating':'4',
        'price':'120$',
        'description': '\uD83D\uDCAA Intel Core i5-11600K: This mid-range CPU from Intel is designed for gamers and power users who want a balance between performance and price. With 6 cores and 12 threads, it can handle most applications and games with ease. It also features Intel\'s latest technologies, including PCIe 4.0 and Thunderbolt 4.'
    },
    {
        'name': 'AMD Ryzen 5 5600X',
        'image': 'cpu5',
        'rating':'4.7',
        'price':'127$',
        'description': '\uD83D\uDD25 AMD Ryzen 5 5600X: This mid-range CPU from AMD is designed for gamers and power users who want a balance between performance and price. With 6 cores and 12 threads, it can handle most applications and games with ease. It also features AMD\'s latest technologies, including PCIe 4.0 and support for DDR4 memory speeds up to 3200MHz.'
    },
    {
        'name': 'Intel Core i3-11100',
        'image': 'cpu6',
        'rating':'2.7',
        'price':'100$',
        'description': '\uD83D\uDCBB Intel Core i3-11100: This entry-level CPU from Intel is designed for budget-conscious users who need a basic level of performance. With 4 cores and 8 threads, it can handle most everyday tasks with ease. It also features Intel\'s latest technologies, including PCIe 4.0 and Thunderbolt 4.'
    },
    {
        'name': 'AMD Ryzen 3 5300G',
        'image': 'cpu7',
        'rating':'3.6',
        'price':'200$',
        'description': '\uD83D\uDE80 AMD Ryzen 3 5300G: This entry-level CPU from AMD is designed for budget-conscious users who need a basic level of performance. With 4 cores and 8 threads, it can handle most everyday tasks with ease. It also features AMD\'s latest technologies, including PCIe 3.0 and support for DDR4 memory speeds up to 3200MHz. It also includes a built-in GPU for basic graphics needs.'
    }
]

@app.route('/')
def get_products():
    return jsonify(products)

if __name__ == '__main__':
    app.run(debug=True)
