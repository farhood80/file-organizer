# File Organizer

A powerful and customizable file organization tool that automatically sorts files into designated folders based on their types, names, or other criteria.

## Features

- 📁 **Automatic File Sorting** - Organizes files by type (images, documents, videos, etc.)
- ⚡ **Fast Processing** - Quick batch processing of multiple files
- 🎯 **Custom Rules** - Define your own organization rules
- 🔄 **Safe Operations** - Prevents overwriting existing files
- 📊 **Progress Tracking** - Real-time progress updates

## Installation

```bash
# Clone the repository
git clone https://github.com/farhood80/file-organizer.git

# Navigate to the project directory
cd file-organizer

# Basic usage
python file_organizer.py --source /path/to/source --destination /path/to/destination

# With custom rules
python file_organizer.py --source /path/to/source --rules custom_rules.json

{
  "image_extensions": [".jpg", ".png", ".gif", ".bmp"],
  "document_extensions": [".pdf", ".doc", ".docx", ".txt"],
  "video_extensions": [".mp4", ".avi", ".mov", ".mkv"]
}


file-organizer/
├── src/
│   ├── file_organizer.py
│   ├── config_loader.py
│   └── file_utils.py
├── tests/
├── docs/
├── requirements.txt
└── README.md
