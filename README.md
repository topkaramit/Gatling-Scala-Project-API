# Go to your local project folder
cd D:\Project\GatlingAPI

# Initialize Git (if not already done)
git init

# Configure your Git identity (only needed once per computer)
git config --global user.email "topkaramit@gmail.com"
git config --global user.name "Amit Topkar"

# Add all files to Git
git add .

# Commit the files
git commit -m "Initial commit"

# Rename current branch to main
git branch -M main

# Link your local repo to the GitHub repo
git remote add origin https://github.com/topkaramit/Gatling-Scala-Project-API.git

# Push your code to GitHub
git push -u origin main
